import{Moment, MomentInput} from 'moment';

export interface IPatient{
    id?: number;
    family?: String;
    given?: String;
    dob?: Moment | null;
    sex?: String;
    address?: String;
    phoneNumber?: String;
}

export class Patient implements IPatient{
    constructor(public id?: number,public family?: String, public given?: String, public dob?: Moment |null, public sex?: String, public address?: String, public phoneNumber?: String){}
}