package custom

import com.kms.katalon.core.annotation.Keyword
import java.net.HttpURLConnection
import java.net.URL
import groovy.json.JsonOutput

class DiscordNotifier {
	@Keyword
	def sendDiscordEmbedMessage(String suiteName, String status, String duration, String reportPath) {
		try {
			String webhookUrl = "https://discord.com/api/webhooks/1372945709351047198/u-iSF0uV_Pb7SEIc7BRuI3SKLC-NCRAQ1a46EuycSMVhs88ErJUtQRhW-SCvNEZoW105"

			// Create the JSON payload for the embed
			def embed = [
				title: "🧪 Test Suite Execution Report",
				color: status == "PASSED" ? 0x00FF00 : 0xFF0000, // green if passed, red otherwise
				fields: [
					[name: "📘 Suite", value: suiteName, inline: false],
					[name: "📊 Status", value: status, inline: true],
					[name: "⏱️ Duration", value: duration, inline: true],
					[name: "📄 Report", value: "Report is available at: ${reportPath}", inline: false]
				],
				timestamp: new Date().format("yyyy-MM-dd'T'HH:mm:ssXXX")
			]


			def payload = JsonOutput.toJson([embeds: [embed]])

			// Send the message
			URL url = new URL(webhookUrl)
			HttpURLConnection connection = (HttpURLConnection) url.openConnection()
			connection.setRequestMethod("POST")
			connection.setRequestProperty("Content-Type", "application/json")
			connection.setDoOutput(true)
			connection.setConnectTimeout(5000) // 5 seconds timeout
			connection.setReadTimeout(5000)    // 5 seconds timeout

			connection.outputStream.withWriter("UTF-8") { writer ->
				writer << payload
			}

			def responseCode = connection.getResponseCode()
			if (responseCode == 200) {
				println "✅ Discord message sent successfully."
				println "Report path: ${reportPath}"
			} else {
				println "❌ Failed to send Discord message. HTTP response code: $responseCode"
				println "Response message: ${connection.getResponseMessage()}"
				
				// Try to read error response
				try {
					def errorStream = connection.getErrorStream()
					if (errorStream) {
						def errorMessage = errorStream.text
						println "Error details: ${errorMessage}"
					}
				} catch (Exception e) {
					println "Could not read error response: ${e.message}"
				}
			}
		} catch (Exception e) {
			println "⚠️ Exception in DiscordNotifier: ${e.message}"
			e.printStackTrace()
		}
	}
}