import { useState } from "react";
import { useNavigate } from 'react-router-dom';
import axios from "axios";
function Login() {

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();
  async function login(event) {
    event.preventDefault();
    try {
      await axios.post("http://localhost:8080/auth/login", {
        username: username,
        password: password,
      }).then((res) => {
        if (res.data.message === "El usuario no existe") {
          alert("El usuario no existe");
        }
        else if (res.data.message === "Login Success") {
          localStorage.setItem('token', res.data.token)
          navigate('/calendar');
        }
        else {
          alert("El nombre de usuario o la contraseña no coinciden");
        }
      }, fail => {
        console.error(fail); // Error!
      });
    }

    catch (err) {
      alert(err);
    }

  }
  return (
    <div>
      <div className="container">
        <div className="column">
          <h2 className="text-center my-4">Login</h2>
          {/* <hr /> */}
        </div>
        <div className="column">
          <div className="col-md-12 col-sm-12 mx-auto">
            <form className="form-width form-control shadow mx-auto py-3 px-4">
              <div className="form-group">
                <label>Nombre de Usuario</label>
                <input
                  type="text"
                  className="form-control"
                  id="email"
                  placeholder="Nombre de Usuario"
                  value={username}
                  autoFocus
                  required
                  onChange={(event) => {
                    setUsername(event.target.value);
                  }}
                />
              </div>
              <div className="form-group mt-2">
                <label>Contraseña</label>
                <input
                  type="password"
                  className="form-control"
                  id="password"
                  placeholder="*********"
                  value={password}
                  required
                  onChange={(event) => {
                    setPassword(event.target.value);
                  }}
                />
              </div>
              <div className="d-flex mt-3">
                <button type="submit" className="btn btn-primary w-100" onClick={login}>
                  Ingresar
                </button>
              </div>
              <p className="mt-3">No tengo cuenta <span className="fw-bold text-primary cursor-pointer" onClick={() => navigate('/register')}>Registrarme</span></p>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}

export default Login;