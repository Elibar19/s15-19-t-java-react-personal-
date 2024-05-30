import { useNavigate } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';

function Home() {
  const navigate = useNavigate();

  const goToLogin = () => {
    navigate('/login');
  };

  const goToRegister = () => {
    navigate('/register');
  };

  return (
    <div className="container d-flex flex-column justify-content-center align-items-center mt-2">
      <div className="text-center">
        <h1>Home</h1>
        <div className="row mt-4">
          <div className="col">
            <button className="btn btn-primary me-2" onClick={goToLogin}>
              Ingresar
            </button>
          </div>
          <div className="col">
            <button className="btn btn-secondary" onClick={goToRegister}>
              Registrarse
            </button>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Home;