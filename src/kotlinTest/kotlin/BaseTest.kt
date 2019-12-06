package kotlinTest

import kotlinTest.manager.AppManager
import org.junit.After
import org.junit.Before

abstract class BaseTest {

    var manager: AppManager = AppManager.getInstance()

    @Before
    open fun setUp() {
    }

    @After
    open fun afterTest() {
    }
}
