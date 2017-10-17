
import { Component, Input } from '@angular/core';

import { User } from '../UserComponent/user';

@Component({
  selector: 'nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['nav-bar.component.css']
})

export class NavBarComponent {
	@Input() user: User;
}