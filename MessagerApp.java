package messangerApp;

import java.util.Scanner;

interface MessagineService {
    String sendMessage();
}

class SMSMessagingService implements MessagineService {

    public String sendMessage() {
        return "Message sent";
    }

}

class ValidateNumber extends SMSMessagingService {
    public String getMobileNumber(String MobileNumber) {
        String regex = "(0/91)?[7-9][0-9]{9}";
        if (MobileNumber.matches(regex)) {
            // return "Hi Nithish\n" + sendMessage();
            return sendMessage();

        } else {
            return "Invalid Number";
        }
    }
}

class EmailMessagingService implements MessagineService {
    public String sendMessage() {
        return "Mail Sent";
    }

    private String subject;
    private String body;

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

}

class ValidateEmail extends EmailMessagingService {

    public String getEmail(String email) {
        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        if (email.matches(regex)) {
            // MailMessage()
            return sendMessage();

        } else {
            return "Invalid Email";
        }

    }
}

class WhatsAppMessagingService implements MessagineService {
    public String sendMessage() {
        return "Message sent";
    }

    private String getUserMessage;

    public String getGetUserMessage() {
        return getUserMessage;
    }

    public void setGetUserMessage(String getUserMessage) {
        this.getUserMessage = getUserMessage;
    }

}

class ValidateWhatsappNumber extends WhatsAppMessagingService {
    public String getWhatsappNumber(String MobileNumber) {
        String regex = "(0/91)?[7-9][0-9]{9}";
        if (MobileNumber.matches(regex)) {
            return sendMessage();
        } else {
            return "Invalid Number";
        }
    }
}

public class MessagerApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte userInput;
        ValidateNumber validatenumber = new ValidateNumber();
        ValidateEmail validateemail = new ValidateEmail();
        ValidateWhatsappNumber validateWhatsappNumber = new ValidateWhatsappNumber();

        do {
            System.out.println("1. For SMS Message\n2. For Email Message\n3. For Whatsapp\n");
            userInput = scanner.nextByte();
            if (userInput == 1) {
                System.out.println("Enter Mobile Number");
                String mobileNumber = scanner.next();
                System.out.println(validatenumber.getMobileNumber(mobileNumber));
            }

            else if (userInput == 2) {
                System.out.println("Enter Mail ID");
                String getMailID = scanner.next();
                System.out.println("Enter subject ");
                String getsubject = scanner.next();
                validateemail.setSubject(getsubject);
                System.out.println("Enter Body ");
                String getBody = scanner.next();
                validateemail.setBody(getBody);
                System.out.println(validateemail.getEmail(getMailID));
            }

            else if (userInput == 3) {
                System.out.println("Enter Whatsapp Number");
                String getWhatsappNumber = scanner.next();
                System.out.println("Enter message to send");
                String getMessage = scanner.next();
                validateWhatsappNumber.setGetUserMessage(getMessage);
                System.out.println(validateWhatsappNumber.getWhatsappNumber(getWhatsappNumber));
            }

            else {
                System.out.println("Invalid Input");
            }
        } while (userInput != 4);
        scanner.close();
    }

}
