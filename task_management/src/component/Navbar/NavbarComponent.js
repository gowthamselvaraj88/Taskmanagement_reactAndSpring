import { Button } from "antd";
import React from "react";
import {
  Container,
    Image,
    Nav, NavLink, Navbar, NavbarBrand
} from 'react-bootstrap';
import NavDropdown from 'react-bootstrap/NavDropdown';
import { Link } from "react-router-dom";

function NavbarComponent(){
    return(
        <div>
             <Navbar bg="dark" data-bs-theme="dark">
        <Container>
          <NavbarBrand href="#">
           Task Management
          </NavbarBrand>
          <Button className='button'><Link className="links" to={'/login'}>Login</Link></Button>
        </Container>
      </Navbar>
        </div>
    )
}

export default NavbarComponent;