package kotlinTest

import org.junit.AfterClass
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
        LoginTest::class,
        AddAddressTest::class,
        EditAccountTest::class
)
object RunTestSuite : BaseTest() {

    @AfterClass
    @JvmStatic
    fun doYourOneTimeTeardown() {
        manager.stop()
    }
}
