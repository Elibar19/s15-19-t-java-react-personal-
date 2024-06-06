import { Calendar, momentLocalizer } from 'react-big-calendar';
import moment from 'moment';
import 'moment/locale/es';
import 'react-big-calendar/lib/css/react-big-calendar.css';

moment.locale('es');
const localizer = momentLocalizer(moment);

const myEventsList = [
  {
    title: 'Evento 1',
    start: new Date(2024, 5, 10, 10, 0), // (año, mes, dia, hora) 10 de junio de 2024 a las 10:00
    end: new Date(2024, 5, 10, 11, 0),   // (año, mes, dia, hora) 10 de junio de 2024 a las 11:00
  },
  {
    title: 'Evento 2',
    start: new Date(2024, 5, 13, 12, 0), // (año, mes, dia, hora) 13 de junio de 2024 a las 12:00
    end: new Date(2024, 5, 13, 13, 0),   // (año, mes, dia, hora) 13 de junio de 2024 a las 13:00
  },
  // Agrega más eventos aquí
];

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

const MyCalendar = () => (
  <div>
    <Calendar
      localizer={localizer}
      events={myEventsList}
      startAccessor="start"
      endAccessor="end"
      style={{ height: 450 }}
      messages={messages}
      className='mt-5 shadow'
    />
  </div>
);

export default MyCalendar;
