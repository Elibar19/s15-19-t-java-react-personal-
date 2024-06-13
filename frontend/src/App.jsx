import { BrowserRouter, Routes, Route } from "react-router-dom";
import './App.css'
import { PrimeReactProvider } from 'primereact/api';
import 'primereact/resources/primereact.min.css';
import 'primeicons/primeicons.css';
import "primereact/resources/themes/fluent-light/theme.css";
import Register from "./components/Register";
import Login from "./components/Login";
import Welcome from "./components/Welcome";
import CalendarPage from "./pages/CalendarPage";
import ProtectedRoutes from "./components/ProtectedRoutes";
import Diary from "./components/Diary";
import UserProfile from "./components/UserProfile";
function App() {
  return (
    <div>
      <PrimeReactProvider>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Login />} />
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />
            <Route path="/welcome" element={<Welcome />} />
            <Route element={<ProtectedRoutes />}>
              <Route path="/calendar" element={<CalendarPage />} />
              <Route path="/diario" element={<Diary />} />
              <Route path="/miperfil" element={<UserProfile />} />
            </Route>
          </Routes>
        </BrowserRouter>
      </PrimeReactProvider>
    </div>
  );
}
export default App;
