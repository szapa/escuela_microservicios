import { Component, OnInit } from '@angular/core';
import { UsuariosService } from '../usuarios.service';
import { Usuario } from '../entidades/Usuario';

@Component({
  selector: 'app-lista-usuarios',
  templateUrl: './lista-usuarios.component.html',
  styleUrls: ['./lista-usuarios.component.css']
})
export class ListaUsuariosComponent implements OnInit {

  listaUsu: Usuario[];
  // Como UsuarioService es @Injectable, Angular lo instancia y lo
  // pasa como argumento del contructor automáticamente. IoD
  // Inyección de dependencias
  constructor(public srvUsu: UsuariosService) { }

  ngOnInit() {
    this.listaUsu = this.srvUsu.getTodosUsuarios();
  }

}
