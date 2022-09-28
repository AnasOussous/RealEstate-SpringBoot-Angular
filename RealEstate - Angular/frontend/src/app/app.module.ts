import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { NotfoundComponent } from './components/notfound/notfound.component';
import { HomeComponent } from './components/home/home.component';
import { SignupComponent } from './user/signup/signup.component';
import { SigninComponent } from './user/signin/signin.component';
import { DashboardComponent } from './user/dashboard/dashboard.component';
import { ContactComponent } from './components/contact/contact.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { httpInterceptorProviders } from './_helpers/http.interceptor';
import { AdmindashboardComponent } from './user/admindashboard/admindashboard.component';
import { CourtierdashboardComponent } from './user/courtierdashboard/courtierdashboard.component';
import { CategorylistComponent } from './components/categorylist/categorylist.component';
import { AddcategoryComponent } from './components/addcategory/addcategory.component';
import { UpdatecategoryComponent } from './components/updatecategory/updatecategory.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {NgxPaginationModule} from 'ngx-pagination';
import { OrderModule } from 'ngx-order-pipe';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { ListingsComponent } from './components/listings/listings.component';
import { CardComponent } from './components/card/card.component';
import { ListingdetailsComponent } from './components/listingdetails/listingdetails.component';
import { UpdatelistingComponent } from './components/updatelisting/updatelisting.component';
import { AddlistingComponent } from './components/addlisting/addlisting.component';
import {MatGridListModule} from '@angular/material/grid-list';
import { DragDirective } from './drag.directive';
import { AgentComponent } from './components/agent/agent.component';
import {TimeAgoPipe} from 'time-ago-pipe';
import { DateAgoPipe } from './_shared/pipes/date-ago.pipe'



@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    NotfoundComponent,
    HomeComponent,
    SignupComponent,
    SigninComponent,
    DashboardComponent,
    ContactComponent,
    AdmindashboardComponent,
    CourtierdashboardComponent,
    CategorylistComponent,
    AddcategoryComponent,
    UpdatecategoryComponent,
    ListingsComponent,
    CardComponent,
    ListingdetailsComponent,
    UpdatelistingComponent,
    AddlistingComponent,
    DragDirective,
    AgentComponent,
    DateAgoPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    BrowserAnimationsModule,
    NgxPaginationModule,
    OrderModule,
    Ng2SearchPipeModule,
    MatGridListModule
  ],
  providers: [httpInterceptorProviders],
  bootstrap: [AppComponent]
})
export class AppModule { }
