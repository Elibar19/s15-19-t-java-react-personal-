import { BrowserRouter, Routes, Route } from "react-router-dom";
import './App.css'
import { PrimeReactProvider } from 'primereact/api';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';
import "primereact/resources/themes/fluent-light/theme.css";
import Register from "./components/Register";
import Login from "./components/Login";
import NavBar from "./components/NavBar"
// import Home from "./components/Home";
import Welcome from "./components/Welcome";
import CalendarPage from "./pages/CalendarPage";
import ProtectedRoutes from "./components/ProtectedRoutes";
function App() {
  return (
    <div>
      <PrimeReactProvider>
        <BrowserRouter>
          <NavBar />

          <Routes>
            <Route path="/" element={<Login />} />
            <Route path="/home" element={<Login />} />
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />
            <Route path="/welcome" element={<Welcome />} />
            <Route element={<ProtectedRoutes />}>
              <Route path="/calendar" element={<CalendarPage />} />
            </Route>
          </Routes>
        </BrowserRouter>
      </PrimeReactProvider>
    </div>
  );
}
export default App;
