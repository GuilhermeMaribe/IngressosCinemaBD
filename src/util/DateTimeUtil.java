package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

/**
 *
 * @author lhries
 */
public class DateTimeUtil {
    //withResolverStyle(STRICT): força a data e hora trabalharem corretamente (ex: mes pode ser só 1 a 12)
    public static DateTimeFormatter formatadorData = 
            DateTimeFormatter.ofPattern("dd/MM/uuuu").withResolverStyle(ResolverStyle.STRICT);
    public static DateTimeFormatter formatadorHora = 
            DateTimeFormatter.ofPattern("HH:mm").withResolverStyle(ResolverStyle.STRICT);
    public static DateTimeFormatter formatadorDataHora = 
            DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm").withResolverStyle(ResolverStyle.STRICT);

    public static LocalDate stringToDate(String dataString)
    {
        return(LocalDate.parse(dataString,formatadorData));
    }

    public static LocalTime stringToTime(String dataString) 
    {
        return(LocalTime.parse(dataString,formatadorHora));
    }

    public static LocalDateTime stringToDateTime(String dataString)
    {
        return(LocalDateTime.parse(dataString,formatadorDataHora));
    }
    
    public static String dateToString(LocalDate data){
        return(data.format(formatadorData));
    }

    public static String timeToString(LocalTime hora){
        return(hora.format(formatadorHora));
    }
    public static String dateTimeToString(LocalDateTime datahora){
        return(datahora.format(formatadorDataHora));
    }
 
}
