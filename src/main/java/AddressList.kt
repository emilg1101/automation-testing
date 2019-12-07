import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "AddressList")
@XmlAccessorType(XmlAccessType.FIELD)
class AddressList {

    @XmlElement(name = "Address")
    var data: MutableList<AddressData> = mutableListOf()
}

@XmlAccessorType(XmlAccessType.FIELD)
class AddressData {

    @XmlElement(name = "FirstName")
    var firstName: String = ""
    @XmlElement(name = "LastName")
    var lastName: String = ""
    @XmlElement(name = "AddressOne")
    var addressOne: String = ""
    @XmlElement(name = "City")
    var city: String = ""
    @XmlElement(name = "Postcode")
    var postcode: String = ""
    @XmlElement(name = "Region")
    var region: String = ""

    override fun toString(): String {
        return "$firstName $lastName\n$addressOne\n$city $postcode\n$region\nUnited Kingdom"
    }
}
