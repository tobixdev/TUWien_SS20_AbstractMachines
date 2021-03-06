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
import com.oracle.truffle.sl.runtime.RingelnatterContext;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.LinkedList;
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
    protected CallTarget parse(ParsingRequest request) {
        RingelnatterContext context = getCurrentContext(RingelnatterLanguage.class);
        Source source = request.getSource();
        RingelnatterLexer lexer = createLexer(source);
        RingelnatterParser parser = createParser(source, lexer);
        RingelnatterTruffleListener listener = new RingelnatterTruffleListener(this, source, context.getFunctionRegistry());
        ParseTreeWalker.DEFAULT.walk(listener, parser.ringelnatter());

        try {
            RootCallTarget main = context.getFunctionRegistry().lookup("main", 0);
            return main;
        } catch (RingelnatterException ex) {
            throw new RingelnatterException("No main method found");
        }
    }

    private RingelnatterLexer createLexer(Source source) {
        RingelnatterLexer lexer = new RingelnatterLexer(CharStreams.fromString(source.getCharacters().toString()));
        lexer.removeErrorListeners();
        lexer.addErrorListener(new BailoutErrorListener(source));
        return lexer;
    }

    private RingelnatterParser createParser(Source source, RingelnatterLexer lexer) {
        RingelnatterParser parser = new RingelnatterParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        parser.addErrorListener(new BailoutErrorListener(source));
        return parser;
    }

    @Override
    protected boolean isObjectOfLanguage(Object object) {
        return object.getClass() == Long.class || object.getClass() == LinkedList.class;
    }
}
