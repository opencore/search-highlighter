package org.wikimedia.search.highlighter.experimental.source;

import org.wikimedia.search.highlighter.experimental.SourceExtracter;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Extracts strings from a String source.
 */
@SuppressFBWarnings(value = "STT_STRING_PARSING_A_FIELD", justification = "This class IS a parser.")
public final class StringSourceExtracter implements SourceExtracter<String> {
    private final String source;

    public StringSourceExtracter(String source) {
        this.source = source;
    }

    @Override
    public String extract(int startOffset, int endOffset) {
        startOffset = Math.max(0, startOffset);
        endOffset = Math.min(endOffset, source.length());
        // May happen on copy_to fields where the data is not
        // part of the source
        if (startOffset >= endOffset) {
            return "";
        }
        return source.substring(startOffset, endOffset);
    }
}
