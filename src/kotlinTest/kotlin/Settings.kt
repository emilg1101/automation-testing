package kotlinTest

import java.io.File
import java.lang.IllegalArgumentException
import javax.xml.bind.JAXBContext
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

object Settings {

    val data: SettingsData = getTestData("Setting.xml") ?: throw IllegalArgumentException()

    private fun getTestData(filename: String): SettingsData? {
        try {
            val jc = JAXBContext.newInstance(SettingsData::class.java)
            val unmarshaller = jc.createUnmarshaller()
            val xml = File(javaClass.classLoader.getResource(filename).file)
            return (unmarshaller.unmarshal(xml) as? SettingsData)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlRootElement(name = "Setting")
    class SettingsData {

        @XmlElement(name = "Email")
        var email: String = ""
        @XmlElement(name = "Password")
        var password: String = ""
        @XmlElement(name = "BaseUrl")
        var baseUrl: String = ""
    }
}