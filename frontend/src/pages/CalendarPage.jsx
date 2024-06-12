import MyCalendar from "../components/MyCalendar"
import NavBar from "../components/NavBar"
const CalendarPage = () => {
    return (
        <>
        <NavBar />
        <div className="container w-100 d-flex justify-content-center align-items-center flex-column">
            <h2 className="my-3 text-primary">Calendario</h2>
            <MyCalendar />
        </div>
        </>
    )
}

export default CalendarPage