package blaster707.contactlist

enum class LocationLabel(val desc: String) {

    Home("Home"),
    Mobile("Mobile"),
    Work("Work"),
    Other("Other");

    companion object LabelFunctions{
        fun labelString(locationLabel: LocationLabel): String { return "$locationLabel" }
    }
}