import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { from } from 'rxjs';
import { AppComponente } from './app.componente';
// Los metadatos de un módulo/comp/serv... es un objeto de JS que le pasamos al @Decorador
@NgModule({
    declarations: [AppComponente],
    imports: [BrowserModule],
    bootstrap: [AppComponente]
})
export class AppModulo{}