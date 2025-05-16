import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.model.FailureHandling
import custom.DiscordNotifier
import java.nio.file.Files
import java.nio.file.Paths
import java.text.SimpleDateFormat

class TestListener {
	/**
	 * Executes before every test suite starts.
	 * @param testSuiteContext: related information of the executed test suite.
	 */
	long startTime
	long endTime

	@BeforeTestSuite
	def beforeTestSuite(TestSuiteContext testSuiteContext) {
		startTime = System.currentTimeMillis()
	}

	@AfterTestSuite
	def afterTestSuite(TestSuiteContext testSuiteContext) {
		long endTime = System.currentTimeMillis()
		long durationMillis = endTime - startTime
		long durationSecs = durationMillis / 1000

		String suiteName = testSuiteContext.getTestSuiteId()
		String status = testSuiteContext.getStatus()
		String duration = "${durationSecs} seconds"

		// Prepare report path
		def date = new Date()
		def dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss")
		def timestamp = dateFormat.format(date)

		String projectDir = System.getProperty("user.dir")
		String reportPath = "${projectDir}/Reports/${timestamp}/${suiteName}/${timestamp}"

		def reportDir = new File(reportPath)
		def pdfFile = reportDir.listFiles()?.find { it.name.endsWith('.pdf') }

		new DiscordNotifier().sendDiscordEmbedMessage(
			suiteName,
			status,
			duration,
			pdfFile?.absolutePath ?: reportPath
		)
	}
}
