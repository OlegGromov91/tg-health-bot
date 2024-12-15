package ru.home.sevice.processor.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum TgMimeTypes {

    WORD("application/msword", AppMediaType.STANDARD_DOCUMENT),
    PDF("application/pdf", AppMediaType.STANDARD_DOCUMENT);

    private final String mimeType;
    private final AppMediaType appType;

    public enum AppMediaType {
        STANDARD_DOCUMENT
    }
}
