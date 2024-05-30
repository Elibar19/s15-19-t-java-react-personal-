import { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
function Register() {

  const [username, setUsername] = useState("");
  //const [role, setRole] = useState("");
  const [password, setPassword] = useState("");
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
          <h2 className="text-center my-4">Crear nueva cuenta</h2>

          <form className="form-width form-control shadow py-3 px-4 mx-auto">
            <div className="form-group">
              <label>Nombre de usuario:</label>
              <input type="text" className="form-control" id="employeename" placeholder="Nombre de usuario"
                autoFocus
                required
                value={username}
                onChange={(event) => {
                  setUsername(event.target.value);
                }}
              />
            </div>
            {/*<div className="form-group">
          <label>Role</label>
          <input type="text"  className="form-control" id="email" placeholder="Role"
          
          value={role}
          onChange={(event) => {
            setRole(event.target.value);
          }}
          
          />
 
        </div>**/}
            <div className="form-group mt-2">
              <label>Contraseña</label>
              <input type="password" className="form-control" id="password" placeholder="*********"
                required
                value={password}
                onChange={(event) => {
                  setPassword(event.target.value);
                }}

              />
            </div>
            <div className="d-flex gap-2 mt-3">
              <button type="submit" className="btn btn-primary w-100" onClick={save} >Crear cuenta</button>
              <button type="button" className="btn btn-secondary w-100" onClick={() => navigate('/home')}>
                Volver atras
              </button>
            </div>

          </form>
        </div>
      </div>
    </div>
  );
}

export default Register;