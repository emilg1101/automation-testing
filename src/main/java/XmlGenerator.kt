import java.io.File
import java.io.FileOutputStream
import javax.xml.bind.JAXBContext
import javax.xml.bind.Marshaller

fun main() {
    XmlGenerator.generate("AddressData.xml", 20)
}

object XmlGenerator {

    fun generate(filename: String, count: Int) {
        val contextObj = JAXBContext.newInstance(AddressList::class.java)

        val marshallerObj = contextObj.createMarshaller()
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true)

        val list = mutableListOf<AddressData>()

        for (i in 1 until count) {
            list.add(AddressData().apply {
                firstName = "Name $i"
                lastName = "Lastname $i"
                addressOne = "AddressOne $i"
                city = "City $i"
                postcode = "12345$i"
                region = "Aberdeen"
            })
        }

        val outputFile = File(javaClass.classLoader.getResource(filename).file)
        marshallerObj.marshal(AddressList().apply { data = list }, FileOutputStream(outputFile))
    }
}
