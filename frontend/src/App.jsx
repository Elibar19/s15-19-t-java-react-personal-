import { BrowserRouter, Routes, Route } from "react-router-dom";
import './App.css'
import { PrimeReactProvider } from 'primereact/api';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';
import "primereact/resources/themes/fluent-light/theme.css";
import Register from "./components/Register";
import Login from "./components/Login";
import NavBar from "./components/NavBar"
import Home from "./components/Home";
import Welcome from "./components/Welcome";
import CalendarPage from "./pages/CalendarPage";
function App() {
  return (
    <div>
      <PrimeReactProvider>
        <BrowserRouter>
          <NavBar />

          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/home" element={<Home />} />
            <Route path="/register" element={<Register />} />
            <Route path="/login" element={<Login />} />
            <Route path="/welcome" element={<Welcome />} />
            <Route path="/calendar" element={<CalendarPage />} />
          </Routes>
        </BrowserRouter>
      </PrimeReactProvider>
    </div>
  );
}
export default App;
