package utility;

import java.util.Properties;

//import javax.activation.DataHandler;
//import javax.activation.DataSource;
//import javax.activation.FileDataSource;

/*
  To use this program, change values for the following three constants,

    SMTP_HOST_NAME -- Has your SMTP Host Name
    SMTP_AUTH_USER -- Has your SMTP Authentication UserName
    SMTP_AUTH_PWD  -- Has your SMTP Authentication Password

  Next change values for fields

  emailMsgTxt  -- Message Text for the Email
  emailSubjectTxt  -- Subject for email
  emailFromAddress -- Email Address whose name will appears as "from" address

  Next change value for "emailList".
  This String array has List of all Email Addresses to Email Email needs to be sent to.


  Next to run the program, execute it as follows,

  SendMailUsingAuthentication authProg = new SendMailUsingAuthentication();
  
  
  Add the below snippet at the end of the test execution report creation.
[sourcecode language=”java”]
SendMail.execute(ExecutionFileName);[/sourcecode]

*/
/* MAIL_DRIVER=smtp
MAIL_HOST=smtp.gmail.com
MAIL_PORT=465
MAIL_USERNAME=testbulkmailings@gmail.com
MAIL_PASSWORD=S3cureP@55*/


/*
public static void main(String args[]) throws Exception
{
	  emailtest smtpMailSender = new emailtest();
	  
  smtpMailSender.postMail( emailList, emailSubjectTxt, emailMsgTxt, emailFromAddress);
  System.out.println("Sucessfully Sent mail to All Users");
}*/


public class SendMail  {

	//reportFileName = TestExecutionResultFileName
	public static String reportFileName = "UQReport.html";
	
	public static void main(String args[]) throws Exception
	{
		
	String path="/home/muthu/work/Selenium/SeleniumUQ/Reports/";

	String[] to={"muthu@iqreateinfotech.com","muthu@iqreatesolutions.com"};
	String[] cc={};
	String[] bcc={"testbulkmailings@gmail.com"};

	SendMail.sendMail("testbulkmailings@gmail.com",
	"S3cureP@55",
	"smtp.gmail.com",
	"465",
	"true",
	"true",
	true,
	"javax.net.ssl.SSLSocketFactory",
	"false",
	to,
	cc,
	bcc,
	"Sub: UQ Regression Test Suite Result",
	"Content : Test Message Content",
	path,
	reportFileName);
	}

	
	public static boolean sendMail(String userName,
	String passWord,
	String host,
	String port,
	String starttls,
	String auth,
	boolean debug,
	String socketFactoryClass,
	String fallback,
	String[] to,
	String[] cc,
	String[] bcc,
	String subject,
	String text,
	String attachmentPath,
	String attachmentName){

	//Object Instantiation of a properties file.
	Properties props = new Properties();

	props.put("mail.smtp.user", userName);

	props.put("mail.smtp.host", host);

	if(!"".equals(port)){
	props.put("mail.smtp.port", port);
	}

	if(!"".equals(starttls)){
	props.put("mail.smtp.starttls.enable",starttls);
	props.put("mail.smtp.auth", auth);
	}

	if(debug){

	props.put("mail.smtp.debug", "true");

	}else{

	props.put("mail.smtp.debug", "false");

	}

	if(!"".equals(port)){
	props.put("mail.smtp.socketFactory.port", port);
	}
	if(!"".equals(socketFactoryClass)){
	props.put("mail.smtp.socketFactory.class",socketFactoryClass);
	}
	if(!"".equals(fallback)){
	props.put("mail.smtp.socketFactory.fallback", fallback);
	}

	try{
/*
	Session session = Session.getDefaultInstance(props, null);

	session.setDebug(debug);

	MimeMessage msg = new MimeMessage(session);

	msg.setText(text);

	msg.setSubject(subject);

	Multipart multipart = new MimeMultipart();
	MimeBodyPart messageBodyPart = new MimeBodyPart();
	DataSource source = new FileDataSource(attachmentPath);
	messageBodyPart.setDataHandler(new DataHandler(source));
	messageBodyPart.setFileName(attachmentName);
	multipart.addBodyPart(messageBodyPart);

	msg.setContent(multipart);
	msg.setFrom(new InternetAddress(userName));

	for(int i=0;i<to.length;i++){
	msg.addRecipient(Message.RecipientType.TO, new
	InternetAddress(to[i]));
	}

	for(int i=0;i<cc.length;i++){
	msg.addRecipient(Message.RecipientType.CC, new
	InternetAddress(cc[i]));
	}

	for(int i=0;i<bcc.length;i++){
	msg.addRecipient(Message.RecipientType.BCC, new
	InternetAddress(bcc[i]));
	}

	msg.saveChanges();

	Transport transport = session.getTransport("smtp");

	transport.connect(host, userName, passWord);

	transport.sendMessage(msg, msg.getAllRecipients());

	transport.close();*/

	return true;

	} catch (Exception mex){
	mex.printStackTrace();
	return false;
	}
	}
	}






/*{

  private static final String SMTP_HOST_NAME = "smtp.gmail.com";
  private static final String SMTP_AUTH_USER = "testbulkmailings@gmail.com";
  private static final String SMTP_AUTH_PWD  = "S3cureP@55";

  private static final String emailMsgTxt      = "Online Order Confirmation Message. Also include the Tracking Number.";
  private static final String emailSubjectTxt  = "Testing email!";
  private static final String emailFromAddress = "testbulkmailings@gmail.com";

  // Add List of Email address to who email needs to be sent to
  private static final String[] emailList = {"testbulkmailings@gmail.com", "muthu@iqreateinfotech.com"};

  public static void main(String args[]) throws Exception
  {
	  emailtest smtpMailSender = new emailtest();
	  
    smtpMailSender.postMail( emailList, emailSubjectTxt, emailMsgTxt, emailFromAddress);
    System.out.println("Sucessfully Sent mail to All Users");
  }


private BodyPart messageBodyPart;

  public void postMail( String recipients[ ], String subject,
                            String message , String from) throws MessagingException
  {
    boolean debug = false;

     //Set the host smtp address
     Properties props = new Properties();
     props.put("mail.smtp.host", SMTP_HOST_NAME);
     props.put("mail.smtp.auth", "true");

    Authenticator auth = new SMTPAuthenticator();
    Session session = Session.getDefaultInstance(props, auth);

    session.setDebug(debug);

    // create a message
    Message msg = new MimeMessage(session);

    // set the from and to address
    InternetAddress addressFrom = new InternetAddress(from);
    msg.setFrom(addressFrom);
  
    // new code added
  Multipart multipart = new MimeMultipart();
 // multipart.addBodyPart(messageBodyPart);

    // Part two is attachment
    messageBodyPart = new MimeBodyPart();
    String filename = "/home/muthu/work/Selenium/SeleniumUQ/Reports/UQReport.html";
    DataSource source = new FileDataSource(filename);
    messageBodyPart.setDataHandler(new DataHandler(source));
    
    messageBodyPart.setFileName("Attachment Here:");
    messageBodyPart.setDescription(message);
    multipart.addBodyPart(messageBodyPart);

    // Put parts in message
   msg.setContent(multipart);

    InternetAddress[] addressTo = new InternetAddress[recipients.length];
    for (int i = 0; i < recipients.length; i++)
    {
        addressTo[i] = new InternetAddress(recipients[i]);
    }
    msg.setRecipients(Message.RecipientType.TO, addressTo); 

  // Setting the Subject and Content Type
msg.setSubject(subject);
    msg.setContent(multipart);
      Transport.send(msg);
 }

/**
* SimpleAuthenticator is used to do simple authentication
* when the SMTP server requires it.

private class SMTPAuthenticator extends javax.mail.Authenticator
{

    public PasswordAuthentication getPasswordAuthentication()
    {
        String username = SMTP_AUTH_USER;
        String password = SMTP_AUTH_PWD;
        return new PasswordAuthentication(username, password);
    }
}*/


