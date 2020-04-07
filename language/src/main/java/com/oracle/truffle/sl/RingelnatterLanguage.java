package com.oracle.truffle.sl;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.TruffleLanguage.ContextPolicy;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.sl.parser.BailoutErrorListener;
import com.oracle.truffle.sl.parser.RingelnatterLexer;
import com.oracle.truffle.sl.parser.RingelnatterParser;
import com.oracle.truffle.sl.parser.RingelnatterTruffleListener;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.Map;

@TruffleLanguage.Registration(id = RingelnatterLanguage.ID, name = "Rngl", defaultMimeType = RingelnatterLanguage.MIME_TYPE, characterMimeTypes = RingelnatterLanguage.MIME_TYPE, contextPolicy = ContextPolicy.SHARED, fileTypeDetectors = RingelnatterFileDetector.class)
public final class RingelnatterLanguage extends TruffleLanguage<RingelnatterContext> {
    public static volatile int counter;

    public static final String ID = "rngl";
    public static final String MIME_TYPE = "application/x-rngl";

    public RingelnatterLanguage() {
        counter++;
    }

    @Override
    protected RingelnatterContext createContext(Env env) {
        return new RingelnatterContext();
    }

    @Override
    protected CallTarget parse(ParsingRequest request) throws Exception {
        Source source = request.getSource();
        RingelnatterLexer lexer = new RingelnatterLexer(CharStreams.fromString(source.getCharacters().toString()));
        RingelnatterParser parser = new RingelnatterParser(new CommonTokenStream(lexer));
        RingelnatterTruffleListener listener = new RingelnatterTruffleListener(this, source, parser);
        parser.addErrorListener(new BailoutErrorListener(source));
        parser.addParseListener(listener);
        ParseTreeWalker.DEFAULT.walk(listener, parser.ringelnatter());

        Map<String, RootCallTarget> functions = listener.getCallTargets();
        RootCallTarget main = functions.get("main");

        if(main == null)
            throw new RingelnatterException("No main method found");

        return main;
    }

    @Override
    protected boolean isObjectOfLanguage(Object object) {
        return false;
    }
}
