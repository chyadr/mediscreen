
export interface IError{
    fieldName?: String;
    message?: String;
}

export class Error implements IError{
    constructor(public fieldName?: String,public message?: String){}
}