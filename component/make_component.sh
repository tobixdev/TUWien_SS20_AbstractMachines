#!/usr/bin/env bash

readonly JAVA_VERSION="${1}"
if [[ $JAVA_VERSION == 1.8* ]]; then
    JRE="jre/"
elif [[ $JAVA_VERSION == 11* ]]; then
    JRE=""
else
    echo "Unkown java version: $JAVA_VERSION"
    exit 1
fi
readonly COMPONENT_DIR="component_temp_dir"
readonly LANGUAGE_PATH="$COMPONENT_DIR/$JRE/languages/rngl"

rm -rf COMPONENT_DIR

mkdir -p "$LANGUAGE_PATH"
cp ../language/target/ringelnatter.jar "$LANGUAGE_PATH"

mkdir -p "$LANGUAGE_PATH/launcher"
cp ../launcher/target/ringelnatter-launcher.jar "$LANGUAGE_PATH/launcher/"

mkdir -p "$LANGUAGE_PATH/bin"
cp ../rngl $LANGUAGE_PATH/bin/

mkdir -p "$COMPONENT_DIR/META-INF"
{
    echo "Bundle-Name: Simple Language";
    echo "Bundle-Symbolic-Name: com.oracle.truffle.sl";
    echo "Bundle-Version: 20.0.0";
    echo 'Bundle-RequireCapability: org.graalvm; filter:="(&(graalvm_version=20.0.0)(os_arch=amd64))"';
    echo "x-GraalVM-Polyglot-Part: True"
} > "$COMPONENT_DIR/META-INF/MANIFEST.MF"

(
cd $COMPONENT_DIR || exit 1
jar cfm ../rngl-component.jar META-INF/MANIFEST.MF .

echo "bin/rngl = ../$JRE/languages/rngl/bin/rngl" > META-INF/symlinks
jar uf ../rngl-component.jar META-INF/symlinks

{
    echo "$JRE"'languages/rngl/bin/rngl = rwxrwxr-x'
} > META-INF/permissions
jar uf ../rngl-component.jar META-INF/permissions
)
rm -rf $COMPONENT_DIR
