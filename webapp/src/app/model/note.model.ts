import{Moment, MomentInput} from 'moment';

export interface INote{
    id?: String;
    patId?: number;
    patient?: String;
    note?: String;
}

export class Note implements INote{
    constructor(public id?: String,public patId?: number, public patient?: String, public note?: String){}
}