package kotlinTest

import kotlinTest.manager.AppManager
import org.junit.After
import org.junit.Before

abstract class BaseTest {

    lateinit var manager: AppManager

    @Before
    open fun setUp() {
        manager = AppManager()
    }

    @After
    open fun afterTest() {
        manager.stop()
    }
}
