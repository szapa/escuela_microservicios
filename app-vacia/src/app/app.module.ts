import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponenteA } from './app.componente-a';
import { AppComponenteB } from './app.componente-b';
import { AppComponenteC } from './app.componente-c';
import { Routes, RouterModule } from '@angular/router';
import { PagNoEncontradaComponent } from './pag-no-encontrada/pag-no-encontrada.component';
import { AppRaizComponent } from './app-raiz/app-raiz.component';

const rutasApp: Routes = [
    /*{path: "raiz", component: AppRaizComponent},*/
    {path: "compa", component: AppComponenteA},
    {path: "compb", component: AppComponenteB},
    {path: "", redirectTo: "/compa", pathMatch: 'full'},
    {path: "**", component: PagNoEncontradaComponent},
];

// Los metadatos de un módulo/comp/serv... es un objeto de JS que le pasamos al @Decorador
@NgModule({
    declarations: [AppRaizComponent, AppComponenteA, AppComponenteB, AppComponenteC, PagNoEncontradaComponent, AppRaizComponent],
    imports: [BrowserModule, 
             RouterModule.forRoot(rutasApp, {enableTracing: true}) // Sólo para depuración
    ],
    bootstrap: [AppRaizComponent]
})
export class AppModulo{}