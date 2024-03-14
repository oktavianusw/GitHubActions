import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class send_message {

    public static void main(String[] args) throws IOException {
        // Replace 'YOUR_BOT_TOKEN' with your actual bot token
        String botToken = "7117892211:AAHojO2FE_vpLg_2phE_F5wvF2QHnbkFfRE";

        // Replace 'YOUR_CHAT_ID' with the chat ID you want to send the message to
        String chatId = "1211264412";

        // The message you want to send
        String message = "Hello, this is a test message from your bot!";

        // Send message using Telegram Bot API
        String urlString = "https://api.telegram.org/bot" + botToken + "/sendMessage";
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");

        String payload = "{\"chat_id\": \"" + chatId + "\", \"text\": \"" + message + "\"}";

        try (OutputStream os = connection.getOutputStream()) {
            byte[] input = payload.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int statusCode = connection.getResponseCode();
        if (statusCode == 200) {
            System.out.println("Message sent successfully!");
        } else {
            System.out.println("Failed to send message. Status code: " + statusCode);
            System.out.println("Response: " + connection.getResponseMessage());
        }
    }
}
