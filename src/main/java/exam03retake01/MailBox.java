package exam03retake01;

import java.util.ArrayList;
import java.util.List;

public class MailBox {

    private List<Mail> mails = new ArrayList<>();


    public void addMail(Mail mail) {
        mails.add(mail);
    }

    public List<Mail> getMails() {
        return mails;
    }

    public List<Mail> findByCriteria(String s) {
        List<Mail> result = new ArrayList<>();
        for (Mail m: mails) {
            if (s.startsWith("from:")) {
                String text = s.substring(5);
                if (text.equals(m.getFrom().getName()) || text.equals(m.getFrom().getEmail())) {
                    result.add(m);
                }
                continue;
            }
            if (s.startsWith("to:")) {
                String text = s.substring(3);
                for (Contact m2: m.getTo()) {
                    if (text.equals(m2.getName()) || text.equals(m2.getEmail())) {
                        result.add(m);
                        continue;
                    }
                }
                continue;
            }

            if (m.getMessage().contains(s) || m.getSubject().contains(s)) {
                result.add(m);
            }
        }

        return result;
    }
}
