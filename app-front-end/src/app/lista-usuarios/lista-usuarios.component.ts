import { Component, OnInit } from '@angular/core';
import { UsuariosService } from '../usuarios.service';
import { Usuario } from '../entidades/Usuario';
import { UsuariosRestService } from '../usuarios-rest.service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-lista-usuarios',
  templateUrl: './lista-usuarios.component.html',
  styleUrls: ['./lista-usuarios.component.css']
})
export class ListaUsuariosComponent implements OnInit {

  listaUsu: Usuario[];
  public srvUsu: UsuariosRestService;
  // Como UsuarioService es @Injectable, Angular lo instancia y lo
  // pasa como argumento del contructor automáticamente. IoD
  // Inyección de dependencias. Esto es como el @Autowired
  constructor(srvUsu: UsuariosRestService) {
    this.srvUsu = srvUsu;
   }

  ngOnInit() {
    let obserConDatos: Observable<Usuario[]> = this.srvUsu.getTodos();
    // Le decimos al objeto Observable que cuando reciba datos,
    // invoque a esta función callback
    obserConDatos.subscribe( datos => this.listaUsu = datos);
  }

}
