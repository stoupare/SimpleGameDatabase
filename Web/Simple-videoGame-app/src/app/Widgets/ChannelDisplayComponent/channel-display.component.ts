
import { Component, Input } from '@angular/core';

import { Channel } from './channel';

@Component({
  selector: 'channel-display',
  templateUrl: './channel-display.component.html',
  styleUrls: ['channel-display.component.css']
})

export class ChannelDisplayComponent {
	@Input() channel: Channel;


	getSrcImage(): string {
	var src = "";
	var type = this.channel.type;

	//Specify the corresponding icon-image source based on the channel type.
	if (type === "twitch") {
		src = "/../assets/images/twitch-icon.png"
	} else {
		src = "/../assets/images/youtube-icon.png"
	}
	return src;
}
}