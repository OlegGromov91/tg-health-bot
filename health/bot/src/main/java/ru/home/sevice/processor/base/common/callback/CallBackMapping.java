package ru.home.sevice.processor.base.common.callback;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Getter
public enum CallBackMapping {

    //Алфавит профессий врачей
    ALPHABET_DOCTORS_SPEC_A("А", CallBackType.ALPHABET_DOCTORS_SPEC, false),
    ALPHABET_DOCTORS_SPEC_B("Б", CallBackType.ALPHABET_DOCTORS_SPEC, false),
    ALPHABET_DOCTORS_SPEC_V("В", CallBackType.ALPHABET_DOCTORS_SPEC, false),
    ALPHABET_DOCTORS_SPEC_G("Г", CallBackType.ALPHABET_DOCTORS_SPEC, false),
    ALPHABET_DOCTORS_SPEC_D("Д", CallBackType.ALPHABET_DOCTORS_SPEC, false),
    ALPHABET_DOCTORS_SPEC_I("И", CallBackType.ALPHABET_DOCTORS_SPEC, false),
    ALPHABET_DOCTORS_SPEC_K("К", CallBackType.ALPHABET_DOCTORS_SPEC, false),
    ALPHABET_DOCTORS_SPEC_L("Л", CallBackType.ALPHABET_DOCTORS_SPEC, false),
    ALPHABET_DOCTORS_SPEC_M("М", CallBackType.ALPHABET_DOCTORS_SPEC, false),
    ALPHABET_DOCTORS_SPEC_N("Н", CallBackType.ALPHABET_DOCTORS_SPEC, false),
    ALPHABET_DOCTORS_SPEC_O("О", CallBackType.ALPHABET_DOCTORS_SPEC, false),
    ALPHABET_DOCTORS_SPEC_P("П", CallBackType.ALPHABET_DOCTORS_SPEC, false),
    ALPHABET_DOCTORS_SPEC_R("Р", CallBackType.ALPHABET_DOCTORS_SPEC, false),
    ALPHABET_DOCTORS_SPEC_S("С", CallBackType.ALPHABET_DOCTORS_SPEC, false),
    ALPHABET_DOCTORS_SPEC_T("Т", CallBackType.ALPHABET_DOCTORS_SPEC, false),
    ALPHABET_DOCTORS_SPEC_Y("У", CallBackType.ALPHABET_DOCTORS_SPEC, false),
    ALPHABET_DOCTORS_SPEC_F("Ф", CallBackType.ALPHABET_DOCTORS_SPEC, false),
    ALPHABET_DOCTORS_SPEC_X("Х", CallBackType.ALPHABET_DOCTORS_SPEC, false),
    ALPHABET_DOCTORS_SPEC_CH("Ч", CallBackType.ALPHABET_DOCTORS_SPEC, false),
    ALPHABET_DOCTORS_SPEC_EE("Э", CallBackType.ALPHABET_DOCTORS_SPEC, false),
    ALPHABET_DOCTORS_SPEC_BACK("Назад", CallBackType.ALPHABET_DOCTORS_SPEC, true),

    //Выбор типа посещения врача,
    TESTS("Сдача анализов", CallBackType.CHOSE_MANIPULATION, false),
    VISITING_DOCTOR("Посещение врача", CallBackMapping.CallBackType.CHOSE_MANIPULATION, false),
    OPERATION("Операция", CallBackMapping.CallBackType.CHOSE_MANIPULATION, false),
    MANIPULATION("Манипуляция", CallBackMapping.CallBackType.CHOSE_MANIPULATION, false),
    CHOSE_MANIPULATION_BACK("Назад", CallBackMapping.CallBackType.CHOSE_MANIPULATION, true),
    ;

    private final String data;
    private final CallBackType callBackType;
    private final boolean isWayBack;

    private static final Map<String, CallBackMapping> CALL_BACK_MAPPINGS = Arrays.stream(values())
            .collect(Collectors.toUnmodifiableMap(CallBackMapping::name, value -> value));

    public static boolean isCanProcessCallBack(String callBackData, CallBackType callBackType) {
        return Optional.ofNullable(CALL_BACK_MAPPINGS.get(callBackData))
                .map(CallBackMapping::getCallBackType)
                .map(innerCallBackType -> innerCallBackType == callBackType)
                .orElse(false);
    }

    public enum CallBackType {
        CHOSE_MANIPULATION,
        ALPHABET_DOCTORS_SPEC
    }

}
