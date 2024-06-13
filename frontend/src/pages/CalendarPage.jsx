import MyCalendar from "../components/MyCalendar"
import NavBar from "../components/NavBar"
import Logo from "../assets/img/icons8-logo-de-google.svg"
const CalendarPage = () => {
    return (
        <>
        <NavBar />
        <div className="container w-100 d-flex justify-content-center align-items-center flex-column">
            <h2 className="my-3">Calendario</h2>
            <MyCalendar />
        </div>
        </>
    )
}


export default CalendarPage