export class Question {
  constructor(
    private _id: number | any=null,
    private _intitule: string = '',
    private _reponse1: string = '',
    private _reponse2: string = '',
    private _reponse3: string = '',
    private _reponse4: string = '',
    private _verif: number = 0
  ) {}


    /**
     * Getter id
     * @return {number }
     */
	public get id(): number  {
		return this._id;
	}

    /**
     * Getter intitule
     * @return {string }
     */
	public get intitule(): string  {
		return this._intitule;
	}

    /**
     * Getter reponse1
     * @return {string }
     */
	public get reponse1(): string  {
		return this._reponse1;
	}

    /**
     * Getter reponse2
     * @return {string }
     */
	public get reponse2(): string  {
		return this._reponse2;
	}

    /**
     * Getter reponse3
     * @return {string }
     */
	public get reponse3(): string  {
		return this._reponse3;
	}

    /**
     * Getter reponse4
     * @return {string }
     */
	public get reponse4(): string  {
		return this._reponse4;
	}

    /**
     * Getter verif
     * @return {number }
     */
	public get verif(): number  {
		return this._verif;
	}

    /**
     * Setter id
     * @param {number } value
     */
	public set id(value: number ) {
		this._id = value;
	}

    /**
     * Setter intitule
     * @param {string } value
     */
	public set intitule(value: string ) {
		this._intitule = value;
	}

    /**
     * Setter reponse1
     * @param {string } value
     */
	public set reponse1(value: string ) {
		this._reponse1 = value;
	}

    /**
     * Setter reponse2
     * @param {string } value
     */
	public set reponse2(value: string ) {
		this._reponse2 = value;
	}

    /**
     * Setter reponse3
     * @param {string } value
     */
	public set reponse3(value: string ) {
		this._reponse3 = value;
	}

    /**
     * Setter reponse4
     * @param {string } value
     */
	public set reponse4(value: string ) {
		this._reponse4 = value;
	}

    /**
     * Setter verif
     * @param {number } value
     */
	public set verif(value: number ) {
		this._verif = value;
	}

}
