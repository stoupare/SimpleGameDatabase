


import { Channel } from './../Widgets/ChannelDisplayComponent/channel';

export class User {
  score: number;
  name: string;
  level: number;
  channels: Array<Channel>;

  log(): void { console.log(this);}

  chArray(): void {
	  let chan = new Array<Channel>();
	  let y = new Channel();
	  y.type = "youtube";
	  let t = new Channel();
	  t.type = "twitch";
	  chan.push(y); chan.push(t);
	  this.channels = chan;
	  }

}