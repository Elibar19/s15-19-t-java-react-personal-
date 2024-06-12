import { useState } from 'react';
import { Calendar, momentLocalizer } from 'react-big-calendar';
import moment from 'moment';
import 'moment/locale/es';
import 'react-big-calendar/lib/css/react-big-calendar.css';
import ModalEvents from './ModalEvents';
import NavBar from './NavBar';

moment.locale('es');
const localizer = momentLocalizer(moment);

const messages = {
  allDay: 'Todo el día',
  previous: 'Anterior',
  next: 'Siguiente',
  today: 'Hoy',
  month: 'Mes',
  week: 'Semana',
  day: 'Día',
  agenda: 'Agenda',
  date: 'Fecha',
  time: 'Hora',
  event: 'Evento',
  noEventsInRange: 'No hay eventos en este rango',
  showMore: total => `+ Ver más (${total})`
};

function MyCalendar() {
  const [events, setEvents] = useState([]);

  const addEvent = (event) => {
    setEvents([...events, {
      title: event.title,
      start: event.start,
      end: event.end
    }]);
  }

  return (
    <div>
      
      {/*<ModalDiario />**/}
      <Calendar
        localizer={localizer}
        events={events}
        startAccessor="start"
        endAccessor="end"
        style={{ height: 450, width: 750 }}
        messages={messages}
        className='shadow'
      />
      <ModalEvents onAddEvent={addEvent} />
    </div>
  );
}

export default MyCalendar;
