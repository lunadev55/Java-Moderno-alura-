import java.time.*;
import java.time.format.DateTimeFormatter;

public class Datas {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
//        System.out.println(today);

        LocalDate olimpiadasRio = LocalDate.of(2010, Month.FEBRUARY, 12);

        int result = today.getYear() - olimpiadasRio.getYear(); // anos

        Period period = Period.between(olimpiadasRio, today);
        System.out.println(period);

        LocalDate localDate = olimpiadasRio.plusYears(4);

        System.out.println(localDate);

        // formatado
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatWithHours = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");

        String dataFormatada = localDate.format(format);

//        String dataFormatadaComHora = localDate.format(formatWithHours);

        LocalDateTime dataFormatadaComHora = LocalDateTime.now();
        System.out.println(dataFormatadaComHora.format(formatWithHours));

        YearMonth mes = YearMonth.now();

        LocalTime localTime = LocalTime.of(15, 30);
        System.out.println("localTime = " + localTime);

    }
}
