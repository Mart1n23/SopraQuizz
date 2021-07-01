import { Question } from "./question";

export class Quiz {
  constructor(
    private _id: number|any = null,
    private _nom: string = '',
    private _niveau: number = 0,
    private _ranked: boolean=true,
    private _questions: Question[] | any = null
  ) {}


    /**
     * Getter id
     * @return {number}
     */
	public get id(): number {
		return this._id;
	}

    /**
     * Getter nom
     * @return {string }
     */
	public get nom(): string  {
		return this._nom;
	}

    /**
     * Getter niveau
     * @return {number }
     */
	public get niveau(): number  {
		return this._niveau;
	}

    /**
     * Getter ranked
     * @return {boolean}
     */
	public get ranked(): boolean {
		return this._ranked;
	}

    /**
     * Getter questions
     * @return {Question[] }
     */
	public get questions(): Question[]  {
		return this._questions;
	}

    /**
     * Setter id
     * @param {number} value
     */
	public set id(value: number) {
		this._id = value;
	}

    /**
     * Setter nom
     * @param {string } value
     */
	public set nom(value: string ) {
		this._nom = value;
	}

    /**
     * Setter niveau
     * @param {number } value
     */
	public set niveau(value: number ) {
		this._niveau = value;
	}

    /**
     * Setter ranked
     * @param {boolean} value
     */
	public set ranked(value: boolean) {
		this._ranked = value;
	}

    /**
     * Setter questions
     * @param {Question[] } value
     */
	public set questions(value: Question[] ) {
		this._questions = value;
	}

}
