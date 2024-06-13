import { useState } from "react";
import { useNavigate } from "react-router-dom";
import Logo from '../assets/img/logo-pagina.png'
import axios from "axios";
function Register() {

  const [username, setUsername] = useState("");
  //const [role, setRole] = useState("");
  const [password, setPassword] = useState("");
  const [nombre, setNombre] = useState("");
  const [apellido, setApellido] = useState("");
  const [email, setEmail] = useState("");
  const navigate = useNavigate();
  async function save(event) {
    event.preventDefault();
    try {
      await axios.post("http://localhost:8080/auth/register", {
        username: username,
        //role: role,
        password: password,
      });
      alert("Registro exitoso");
      navigate('/login')
    } catch (err) {
      alert(err);
    }
  }

  return (
    <div>
      <div className="container mt-4" >
        <div className="">
          <h2 className="text-center my-4 color-brown">Crear Cuenta</h2>

          <form className="form-width form-control shadow pt-3 px-4 mx-auto">
            <div className="w-100 d-flex justify-content-center mb-1">
              <img className="mx-auto rounded-circle" width={100} src={Logo} alt="" />
            </div>
            <div className="form-group">
              <label>Username:</label>
              <input type="text" className="form-control" id="employeename" placeholder="Username"
                autoFocus
                required
                value={username}
                onChange={(event) => {
                  setUsername(event.target.value);
                }}
              />
            </div>
            <div className="form-group mt-1">
              <label>Nombre:</label>
              <input type="text" className="form-control" id="employeenombre" placeholder="Nombre"
                autoFocus
                required
                value={nombre}
                onChange={(event) => {
                  setNombre(event.target.value);
                }}
              />
            </div>
            <div className="form-group mt-1">
              <label>Apellido:</label>
              <input type="text" className="form-control" id="employeeapellido" placeholder="Apellido"
                autoFocus
                required
                value={apellido}
                onChange={(event) => {
                  setApellido(event.target.value);
                }}
              />
            </div>

            <div className="form-group mt-1">
              <label>Email:</label>
              <input type="email" className="form-control" id="employeeemail" placeholder="Email"
                autoFocus
                required
                value={email}
                onChange={(event) => {
                  setEmail(event.target.value);
                }}
              />
            </div>

            <div className="form-group mt-1">
              <label>Contraseña</label>
              <input type="password" className="form-control" id="password" placeholder="*********"
                required
                value={password}
                onChange={(event) => {
                  setPassword(event.target.value);
                }}

              />
            </div>
            <div className="d-flex gap-2 mt-2">
              <button type="submit" className="btn button color-brown fw-bold w-100" onClick={save} >Crear cuenta</button>
            </div>
            <p className="mt-2">Ya tengo una cuenta <span className="fw-bold text-primary cursor-pointer" onClick={() => navigate('/login')}>Iniciar Sesión</span></p>
          </form>
        </div>
      </div>
    </div>
  );
}

export default Register;