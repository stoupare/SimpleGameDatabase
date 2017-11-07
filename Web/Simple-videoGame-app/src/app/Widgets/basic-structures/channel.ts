
export class Channel {
  type: string; 
  name: string;
  description: string;
  iconUrl: string;
  latestVideo: string;

  stats: Array<{ subs: number, likes: number, uploads: number}>;

  log(): void {console.log(this);}
}