import { Component, OnInit } from '@angular/core';
import { Usuario } from '../entidades/Usuario';
import { UsuariosRestService } from '../usuarios-rest.service';
import { from } from 'rxjs';

@Component({
  selector: 'app-registro-usuario',
  templateUrl: './registro-usuario.component.html',
  styleUrls: ['./registro-usuario.component.css']
})
export class RegistroUsuarioComponent implements OnInit {

  usuario: Usuario = new Usuario();
  variable = "un valor";
  password: string ="123";
  estaRegistrado: boolean = false;

  constructor(private usuSrv: UsuariosRestService) {
    this.usuario = new Usuario();
   }

  ngOnInit() {
  }

  enviarDatos(){

    this.usuSrv.registro(this.usuario).subscribe((usuRecibido) => {
      this.usuario = usuRecibido;
      if (typeof this.usuario.id !==undefined){
        this.estaRegistrado = true;
      }
    });
    console.log(this.usuario.nombre);
    console.log(this.usuario.email);
    console.log(this.usuario.password);
  }

  pulsar(){
    this.variable = "OTRO VALOR";
  }
}
