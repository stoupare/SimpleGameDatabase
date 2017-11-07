
import { Component, Input } from '@angular/core';

import { User } from './user';
import { Channel } from '../Widgets/basic-structures/channel';

@Component({
  selector: 'user-detail',
  templateUrl: `./user-detail.component.html`
})

export class UserDetailComponent {
	@Input() user: User;

	 chArray(): void {
		  let chan = new Array<Channel>();
		  let y = new Channel();
		  y.type = "youtube"; y.name="SeaNanners"; y.description="Just some random **** to fill up space and yo ass crusty af duublllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllllll lllllllllllllllllllllllllllllllllllllllllllllllllllllkmmmmmmmmmmmmm mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmrccccccccccccccccccccccc"
		  let t = new Channel();
		  t.type = "twitch"; t.name="xxplop345x"; t.description = "So like you like to watch creepy ass shiiiizzzller"
		  chan.push(y); chan.push(t);
		  this.user.channels = chan;
	  }

	  log(): void {
	  	console.log(this.user)
	  }
}