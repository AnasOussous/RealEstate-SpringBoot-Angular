import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddcategoryComponent } from './components/addcategory/addcategory.component';
import { AddlistingComponent } from './components/addlisting/addlisting.component';
import { AgentComponent } from './components/agent/agent.component';
import { CategorylistComponent } from './components/categorylist/categorylist.component';
import { ContactComponent } from './components/contact/contact.component';
import { HomeComponent } from './components/home/home.component';
import { ListingdetailsComponent } from './components/listingdetails/listingdetails.component';
import { ListingsComponent } from './components/listings/listings.component';
import { NotfoundComponent } from './components/notfound/notfound.component';
import { UpdatecategoryComponent } from './components/updatecategory/updatecategory.component';
import { UpdatelistingComponent } from './components/updatelisting/updatelisting.component';
import { AdmindashboardComponent } from './user/admindashboard/admindashboard.component';
import { CourtierdashboardComponent } from './user/courtierdashboard/courtierdashboard.component';
import { DashboardComponent } from './user/dashboard/dashboard.component';
import { SigninComponent } from './user/signin/signin.component';
import { SignupComponent } from './user/signup/signup.component';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent},
  { path: 'signup', component: SignupComponent},
  { path: 'signin', component: SigninComponent},
  { path: 'dashboard', component: DashboardComponent},
  { path: 'admindashboard', component: AdmindashboardComponent},
  { path: 'courtierdashboard', component: CourtierdashboardComponent},
  { path: 'contact', component: ContactComponent},
  { path: 'category', component: CategorylistComponent},
  { path: 'category/:id', component: CategorylistComponent},
  { path: 'listings', component: ListingsComponent},
  { path: 'listingdetails/:id', component: ListingdetailsComponent},
  { path: 'listings/:id', component: UpdatelistingComponent},
  { path: 'addlistings', component: AddlistingComponent},
  { path: 'agent', component: AgentComponent},
  { path: '**', component: NotfoundComponent},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
