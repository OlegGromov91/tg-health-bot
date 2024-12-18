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

    //Выбор типа посещения врача,
    MANIPULATION("Манипуляция", CallBackType.CHOSE_MANIPULATION, CallBackType.NONE),
    TESTS("Сдача анализов", CallBackType.CHOSE_MANIPULATION, CallBackType.NONE),
    VISITING_DOCTOR("Посещение врача", CallBackType.CHOSE_MANIPULATION, CallBackType.NONE),
    OPERATION("Операция", CallBackType.CHOSE_MANIPULATION, CallBackType.NONE),

    //Алфавит профессий врачей
    A_ALPHABET_DOCTORS_SPEC("А", CallBackType.ALPHABET_DOCTORS_SPEC, CallBackType.NONE),
    B_ALPHABET_DOCTORS_SPEC("Б", CallBackType.ALPHABET_DOCTORS_SPEC, CallBackType.NONE),
    C_ALPHABET_DOCTORS_SPEC("Ч", CallBackType.ALPHABET_DOCTORS_SPEC, CallBackType.NONE),
    D_ALPHABET_DOCTORS_SPEC("Д", CallBackType.ALPHABET_DOCTORS_SPEC, CallBackType.NONE),
    E_ALPHABET_DOCTORS_SPEC("Э", CallBackType.ALPHABET_DOCTORS_SPEC, CallBackType.NONE),
    F_ALPHABET_DOCTORS_SPEC("Ф", CallBackType.ALPHABET_DOCTORS_SPEC, CallBackType.NONE),
    G_ALPHABET_DOCTORS_SPEC("Г", CallBackType.ALPHABET_DOCTORS_SPEC, CallBackType.NONE),
    H_ALPHABET_DOCTORS_SPEC("Х", CallBackType.ALPHABET_DOCTORS_SPEC, CallBackType.NONE),
    I_ALPHABET_DOCTORS_SPEC("И", CallBackType.ALPHABET_DOCTORS_SPEC, CallBackType.NONE),
    K_ALPHABET_DOCTORS_SPEC("К", CallBackType.ALPHABET_DOCTORS_SPEC, CallBackType.NONE),
    L_ALPHABET_DOCTORS_SPEC("Л", CallBackType.ALPHABET_DOCTORS_SPEC, CallBackType.NONE),
    M_ALPHABET_DOCTORS_SPEC("М", CallBackType.ALPHABET_DOCTORS_SPEC, CallBackType.NONE),
    N_ALPHABET_DOCTORS_SPEC("Н", CallBackType.ALPHABET_DOCTORS_SPEC, CallBackType.NONE),
    O_ALPHABET_DOCTORS_SPEC("О", CallBackType.ALPHABET_DOCTORS_SPEC, CallBackType.NONE),
    P_ALPHABET_DOCTORS_SPEC("П", CallBackType.ALPHABET_DOCTORS_SPEC, CallBackType.NONE),
    R_ALPHABET_DOCTORS_SPEC("Р", CallBackType.ALPHABET_DOCTORS_SPEC, CallBackType.NONE),
    S_ALPHABET_DOCTORS_SPEC("С", CallBackType.ALPHABET_DOCTORS_SPEC, CallBackType.NONE),
    T_ALPHABET_DOCTORS_SPEC("Т", CallBackType.ALPHABET_DOCTORS_SPEC, CallBackType.NONE),
    U_ALPHABET_DOCTORS_SPEC("У", CallBackType.ALPHABET_DOCTORS_SPEC, CallBackType.NONE),
    V_ALPHABET_DOCTORS_SPEC("В", CallBackType.ALPHABET_DOCTORS_SPEC, CallBackType.NONE),
    BACK_ALPHABET_DOCTORS_SPEC("Назад", CallBackType.ALPHABET_DOCTORS_SPEC, CallBackType.CHOSE_MANIPULATION),

    A_DOCTORS_SPEC_AKUSHER("Акушер", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    A_DOCTORS_SPEC_AKUSHER_GINEKOLOG("Акушер-гинеколог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    A_DOCTORS_SPEC_ALLERGOLOG("Аллерголог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    A_DOCTORS_SPEC_ANDROLOG("Андролог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    A_DOCTORS_SPEC_ANESTEZIOLOG("Анестезиолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    A_DOCTORS_SPEC_ANESTEZIOLOG_REANIMATOLOG("Анестезиолог-реаниматолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    A_DOCTORS_SPEC_ANGIOHIRURG("Ангиохирург", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    A_DOCTORS_SPEC_AUDIOLOG("Аудиолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    B_DOCTORS_SPEC_BAKTERIOLOG("Бактериолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    C_DOCTORS_SPEC_CHELYUSTNO_LICEVOY_HIRURG("Челюстно-лицевой хирург", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    D_DOCTORS_SPEC_DERMATOLOG("Дерматолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    D_DOCTORS_SPEC_DERMATOVENEROLOG("Дерматовенеролог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    D_DOCTORS_SPEC_DETSKIY_ENDOKRINOLOG("Детский эндокринолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    D_DOCTORS_SPEC_DETSKIY_GASTROENTEROLOG("Детский гастроэнтеролог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    D_DOCTORS_SPEC_DETSKIY_GINEKOLOG("Детский гинеколог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    D_DOCTORS_SPEC_DETSKIY_HIRURG("Детский хирург", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    D_DOCTORS_SPEC_DETSKIY_KARDIOLOG("Детский кардиолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    D_DOCTORS_SPEC_DETSKIY_PSIHIATR("Детский психиатр", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    D_DOCTORS_SPEC_DETSKIY_STOMATOLOG("Детский стоматолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    D_DOCTORS_SPEC_DETSKIY_UROLOG_ANDROLOG("Детский уролог-андролог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    D_DOCTORS_SPEC_DIETOLOG("Диетолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    D_DOCTORS_SPEC_DRUGAYA_SPECIALNOST("Другая специальность", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    E_DOCTORS_SPEC_EMBRIOLOG("Эмбриолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    E_DOCTORS_SPEC_ENDOKRINOLOG("Эндокринолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    E_DOCTORS_SPEC_ENDOSKOPIST("Эндоскопист", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    E_DOCTORS_SPEC_EPIDEMIOLOG("Эпидемиолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    E_DOCTORS_SPEC_EPILEPTOLOG("Эпилептолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    F_DOCTORS_SPEC_FARMACEVT("Фармацевт", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    F_DOCTORS_SPEC_FELDSHER("Фельдшер", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    F_DOCTORS_SPEC_FIZIOTERAPEVT("Физиотерапевт", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    F_DOCTORS_SPEC_FLEBOLOG("Флеболог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    F_DOCTORS_SPEC_FONIATR("Фониатр", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    F_DOCTORS_SPEC_FTIZIATR("Фтизиатр", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    G_DOCTORS_SPEC_GASTROENTEROLOG("Гастроэнтеролог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    G_DOCTORS_SPEC_GEMATOLOG("Гематолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    G_DOCTORS_SPEC_GENETIK("Генетик", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    G_DOCTORS_SPEC_GEPATOLOG("Гепатолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    G_DOCTORS_SPEC_GERIATR("Гериатр", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    G_DOCTORS_SPEC_GIGIENIST("Гигиенист", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    G_DOCTORS_SPEC_GINEKOLOG("Гинеколог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    G_DOCTORS_SPEC_GIRUDOTERAPEVT("Гирудотерапевт", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    G_DOCTORS_SPEC_GOMEOPAT("Гомеопат", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    H_DOCTORS_SPEC_HIRURG("Хирург", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    H_DOCTORS_SPEC_HIRURG_IMPLANTOLOG("Хирург-имплантолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    I_DOCTORS_SPEC_IMMUNOLOG("Иммунолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    I_DOCTORS_SPEC_INFEKCIONIST("Инфекционист", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    K_DOCTORS_SPEC_KARDIOLOG("Кардиолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    K_DOCTORS_SPEC_KINEZITERAPEVT("Кинезитерапевт", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    K_DOCTORS_SPEC_KLINICHESKIY_FARMAKOLOG("Клинический фармаколог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    K_DOCTORS_SPEC_KOLOPROKTOLOG("Колопроктолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    K_DOCTORS_SPEC_KOSMETOLOG("Косметолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    L_DOCTORS_SPEC_LABORANT("Лаборант", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    L_DOCTORS_SPEC_LOGOPED("Логопед", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    L_DOCTORS_SPEC_LOR_OTORINOLARINGOLOG("ЛОР (Оториноларинголог)", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    M_DOCTORS_SPEC_MAMMOLOG("Маммолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    M_DOCTORS_SPEC_MANUALNYY_TERAPEVT("Мануальный терапевт", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    M_DOCTORS_SPEC_MASSAZHIST("Массажист", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    M_DOCTORS_SPEC_MEDICINSKAYA_SESTRA("Медицинская сестра", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    M_DOCTORS_SPEC_MEDICINSKIY_BRAT("Медицинский брат", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    M_DOCTORS_SPEC_MEDICINSKIY_DIREKTOR("Медицинский директор", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    M_DOCTORS_SPEC_MIKOLOG("Миколог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    N_DOCTORS_SPEC_NARKOLOG("Нарколог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    N_DOCTORS_SPEC_NEFROLOG("Нефролог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    N_DOCTORS_SPEC_NEONATOLOG("Неонатолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    N_DOCTORS_SPEC_NEVROLOG("Невролог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    N_DOCTORS_SPEC_NEYROFIZIOLOG("Нейрофизиолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    N_DOCTORS_SPEC_NEYROHIRURG("Нейрохирург", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    O_DOCTORS_SPEC_OKULIST_OFTALMOLOG("Окулист (Офтальмолог)", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    O_DOCTORS_SPEC_ONKOLOG("Онколог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    O_DOCTORS_SPEC_ORTOPED("Ортопед", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    O_DOCTORS_SPEC_OSTEOPAT("Остеопат", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    P_DOCTORS_SPEC_PARAZITOLOG("Паразитолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    P_DOCTORS_SPEC_PARODONTOLOG("Пародонтолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    P_DOCTORS_SPEC_PATOLOGOANATOM("Патологоанатом", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    P_DOCTORS_SPEC_PEDAGOG("Педагог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    P_DOCTORS_SPEC_PEDIATR("Педиатр", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    P_DOCTORS_SPEC_PLASTICHESKIY_HIRURG("Пластический хирург", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    P_DOCTORS_SPEC_PROFPATOLOG("Профпатолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    P_DOCTORS_SPEC_PROKTOLOG("Проктолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    P_DOCTORS_SPEC_PSIHIATR("Психиатр", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    P_DOCTORS_SPEC_PSIHIATR_NARKOLOG("Психиатр-нарколог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    P_DOCTORS_SPEC_PSIHOLOG("Психолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    P_DOCTORS_SPEC_PSIHOTERAPEVT("Психотерапевт", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    P_DOCTORS_SPEC_PULMONOLOG("Пульмонолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    R_DOCTORS_SPEC_RADIOLOG("Радиолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    R_DOCTORS_SPEC_REABILITOLOG("Реабилитолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    R_DOCTORS_SPEC_REANIMATOLOG("Реаниматолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    R_DOCTORS_SPEC_REFLEKSOTERAPEVT("Рефлексотерапевт", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    R_DOCTORS_SPEC_RENTGENOLOG("Рентгенолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    R_DOCTORS_SPEC_REPRODUKTOLOG_EKO("Репродуктолог (ЭКО)", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    R_DOCTORS_SPEC_REVMATOLOG("Ревматолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    S_DOCTORS_SPEC_SEKSOLOG("Сексолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    S_DOCTORS_SPEC_SERDECHNO_SOSUDISTYY_HIRURG("Сердечно-сосудистый хирург", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    S_DOCTORS_SPEC_SOMNOLOG("Сомнолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    S_DOCTORS_SPEC_STOMATOLOG("Стоматолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    S_DOCTORS_SPEC_STOMATOLOG_DETSKIY("Стоматолог детский", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    S_DOCTORS_SPEC_STOMATOLOG_GIGIENIST("Стоматолог-гигиенист", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    S_DOCTORS_SPEC_STOMATOLOG_HIRURG("Стоматолог-хирург", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    S_DOCTORS_SPEC_STOMATOLOG_IMPLANTOLOG("Стоматолог-имплантолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    S_DOCTORS_SPEC_STOMATOLOG_ORTODONT("Стоматолог-ортодонт", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    S_DOCTORS_SPEC_STOMATOLOG_ORTOPED("Стоматолог-ортопед", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    S_DOCTORS_SPEC_STOMATOLOG_TERAPEVT("Стоматолог-терапевт", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    S_DOCTORS_SPEC_SURDOLOG("Сурдолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    T_DOCTORS_SPEC_TERAPEVT("Терапевт", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    T_DOCTORS_SPEC_TOKSIKOLOG("Токсиколог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    T_DOCTORS_SPEC_TRANSFUZIOLOG("Трансфузиолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    T_DOCTORS_SPEC_TRANSPLANTOLOG("Трансплантолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    T_DOCTORS_SPEC_TRAVMATOLOG("Травматолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    T_DOCTORS_SPEC_TRAVMATOLOG_ORTOPED("Травматолог-ортопед", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    T_DOCTORS_SPEC_TRIHOLOG("Трихолог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    U_DOCTORS_SPEC_UROLOG("Уролог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    V_DOCTORS_SPEC_VENEROLOG("Венеролог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    V_DOCTORS_SPEC_VERTEBROLOG("Вертебролог", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    V_DOCTORS_SPEC_VRACH_FUNKCIONALNOY_DIAGNOSTIKI("Врач функциональной диагностики", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    V_DOCTORS_SPEC_VRACH_LABORATORNOY_DIAGNOSTIKI("Врач лабораторной диагностики", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    V_DOCTORS_SPEC_VRACH_LECHEBNOY_FIZKULTURY("Врач лечебной физкультуры", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    V_DOCTORS_SPEC_VRACH_MAGNITNO_REZONANSNOY_TOMOGRAFII("Врач магнитно-резонанснойтомографии", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    V_DOCTORS_SPEC_VRACH_OBSCHEY_PRAKTIKI("Врач общей практики", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    V_DOCTORS_SPEC_VRACH_SPORTIVNOY_MEDICINY("Врач спортивной медицины", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    V_DOCTORS_SPEC_VRACH_ULTRAZVUKOVOY_DIAGNOSTIKI("Врач ультразвуковой диагностики", CallBackType.DOCTORS_SPEC, CallBackType.NONE),
    BACK_DOCTORS_SPEC("Назад", CallBackType.DOCTORS_SPEC, CallBackType.ALPHABET_DOCTORS_SPEC),
    ;

    public static final String BACK_CALL_BACK_DATA = "Назад";
    private final String data;
    /**
     * указывает на тип колбека, который будет обрабатывать запрос
     */
    private final CallBackType callBackType;
    /**
     * указывает на тип колбека, который будет обрабатывать кнопку назад
     */
    private final CallBackType backCallBackType;

    private static final Map<String, CallBackMapping> CALL_BACK_MAPPINGS = Arrays.stream(values())
            .collect(Collectors.toUnmodifiableMap(CallBackMapping::name, value -> value));

    public static boolean isCanProcessCallBack(String callBackData, CallBackType callBackType) {
        return Optional.ofNullable(CALL_BACK_MAPPINGS.get(callBackData))
                .filter(CallBackMapping::isNotBackWayData)
                .map(CallBackMapping::getCallBackType)
                .map(innerCallBackType -> innerCallBackType == callBackType)
                .orElse(false);
    }

    public static boolean isBackWayCallBack(String callBackData, CallBackType callBackType) {
        return Optional.ofNullable(CALL_BACK_MAPPINGS.get(callBackData))
                .filter(CallBackMapping::isBackWayData)
                .map(CallBackMapping::getBackCallBackType)
                .map(innerCallBackType -> innerCallBackType == callBackType)
                .orElse(false);
    }

    public boolean isBackWayData() {
        return isBackWayData(data);
    }

    public boolean isNotBackWayData() {
        return !isBackWayData(data);
    }

    public static boolean isBackWayData(String data) {
        return BACK_CALL_BACK_DATA.equals(data);
    }

    public static boolean isNotBackWayData(String data) {
        return !BACK_CALL_BACK_DATA.equals(data);
    }

    public static Optional<CallBackMapping> getCallBack(String callBackData) {
        return Optional.ofNullable(CALL_BACK_MAPPINGS.get(callBackData));
    }

    public enum CallBackType {
        CHOSE_MANIPULATION,
        ALPHABET_DOCTORS_SPEC,
        DOCTORS_SPEC,
        NONE
    }

}
