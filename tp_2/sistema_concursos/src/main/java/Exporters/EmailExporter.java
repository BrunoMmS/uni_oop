package Exporters;

import Exporters.DataExporter;
import Models.Participante;
import io.github.cdimascio.dotenv.Dotenv;
import io.mailtrap.client.MailtrapClient;
import io.mailtrap.config.MailtrapConfig;
import io.mailtrap.factory.MailtrapClientFactory;
import io.mailtrap.model.request.emails.Address;
import io.mailtrap.model.request.emails.MailtrapMail;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class EmailExporter implements DataExporter {

    private static final Dotenv dotenv = Dotenv.load();
    private static final String TOKEN = dotenv.get("MAILTRAP_TOKEN");
    private static final Long INBOX_ID = Long.parseLong(dotenv.get("MAILTRAP_INBOX_ID"));

    @Override
    public void export(Participante p, UUID idConcurso, LocalDate fechaInscripcion) {
        final MailtrapConfig config = new MailtrapConfig.Builder()
                .sandbox(true)
                .inboxId(INBOX_ID)
                .token(TOKEN)
                .build();

        final MailtrapClient client = MailtrapClientFactory.createMailtrapClient(config);

        final MailtrapMail mail = MailtrapMail.builder()
                .from(new Address("hello@example.com", "Mailtrap Test"))
                .to(List.of(new Address(dotenv.get("MI_CORREO"))))
                .subject("Inscripción confirmada")
                .text(String.format("Hola %s %s!\nEstás inscripto al concurso %s con fecha: %s.",
                        p.getName(), p.getLastName(), idConcurso.toString(), fechaInscripcion))
                .category("Inscripción")
                .build();

        try {
            System.out.println(client.send(mail));
        } catch (Exception e) {
            System.out.println("Caught exception : " + e);
        }
    }
}
