import { Injectable } from '@angular/core';
import { AlmacenLocalService } from './almacen-local.service';
import { Usuario } from './entidades/Usuario';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuariosRestService {

  url = "http://localhost:8081/api/json/usuarios";
  listaUsuario: Usuario[];

  constructor(
    public almSrv: AlmacenLocalService,
    public clienteHttp: HttpClient) { }

  getTodos(): Observable<Usuario[]>{
    let observableHttp = this.clienteHttp.get<Usuario[]>(this.url);
    return observableHttp;
  }

  registro(usuario: Usuario): Observable<Usuario>{
    return this.clienteHttp.post<Usuario>(this.url, usuario);
  }

  eliminarRegistro(id: number): Observable<any>{
    /*let urlId = this.url + "/" + this.usu.id;*/
    return this.clienteHttp.delete<any>(`${this.url}/${id}`);
  }

  modificarRegistro(indice: number, usuario: Usuario): Observable<Usuario>{
    return this.clienteHttp.put<Usuario>(`${this.url}/${indice}`, usuario);
  }
}
