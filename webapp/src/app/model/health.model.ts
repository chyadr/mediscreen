
export interface IHealth{
    patient?: String;
    age?: number;
    patientStatus?: String;
}

export class Health implements IHealth{
    constructor(public patient?: String,public age?: number, public patientStatus?: String){}
}