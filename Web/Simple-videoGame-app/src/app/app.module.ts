import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { UserDetailComponent } from './UserComponent/user-detail.component';
import { NavBarComponent } from './NavBarComponent/nav-bar.component';
import { ChannelDisplayComponent } from './Widgets/ChannelDisplayComponent/channel-display.component';

@NgModule({
  declarations: [
    AppComponent,
    UserDetailComponent,
    NavBarComponent,
    ChannelDisplayComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
